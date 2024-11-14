package lian.sample.config

import com.zaxxer.hikari.HikariDataSource
import lian.sample.jpa.MasterSlaveRoutingDataSource
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages = ["lian.sample.domain"],
  entityManagerFactoryRef = "orderEntityManagerFactory",
  transactionManagerRef = "orderTransactionManager"
)
class OrderDataSourceConfiguration(
  private val jpaProperties: JpaProperties
) {

  @Bean
  @ConfigurationProperties("datasource.order.master")
  fun orderMasterDatasource(): DataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()

  @Bean
  @ConfigurationProperties("datasource.order.slave")
  fun orderSlaveDatasource(): DataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()

  @Bean
  fun orderRoutingDataSource() = MasterSlaveRoutingDataSource().apply {
    setTargetDataSources(hashMapOf<Any, Any>(
      "master" to orderMasterDatasource(),
      "slave" to orderSlaveDatasource()))
    setDefaultTargetDataSource(orderMasterDatasource())
  }

  @Primary
  @Bean
  fun orderLazyDataSource() = LazyConnectionDataSourceProxy(orderRoutingDataSource())

  @Primary
  @Bean("orderEntityManagerFactory")
  fun orderEntityManagerFactory() = LocalContainerEntityManagerFactoryBean().apply {
    dataSource = orderLazyDataSource()
    setPackagesToScan("lian.sample.domain")
    jpaVendorAdapter = HibernateJpaVendorAdapter().apply {
      setShowSql(jpaProperties.isShowSql)
      setGenerateDdl(jpaProperties.isGenerateDdl)
      setJpaPropertyMap(jpaProperties.properties)
    }
    persistenceUnitName = "orderEntityManager"
    afterPropertiesSet()
  }

  @Primary
  @Bean("orderTransactionManager")
  fun orderTransactionManager() = JpaTransactionManager(orderEntityManagerFactory().`object`!!)
}

