package lian.sample.domain.custom

import com.fasterxml.jackson.databind.ObjectMapper
import com.querydsl.core.types.dsl.BooleanExpression
import lian.sample.domain.entity.ProductEntity
import lian.sample.domain.entity.QCategoryEntity.categoryEntity
import lian.sample.domain.entity.QOptionGroupEntity.optionGroupEntity
import lian.sample.domain.entity.QProductEntity.productEntity
import lian.sample.presentation.dto.category.Category
import lian.sample.presentation.dto.optionGroup.OptionGroup
import lian.sample.presentation.dto.product.ProductRes

class ProductRepositoryCustomImpl(
  private val objectMapper: ObjectMapper
) : ProductQueryDslRepositorySupport(ProductEntity::class.java),
  ProductRepositoryCustom {
  override fun findAllBySearchCondition(categoryId: Long?): List<ProductRes> {
    val results = queryFactory.select(
        productEntity.id,
        productEntity.name,
        productEntity.price,
        productEntity.color,
        categoryEntity,
        optionGroupEntity,
        productEntity.isTaxIncluded,
        productEntity.status
      )
      .from(productEntity)
      .join(categoryEntity).on(categoryEntity.id.eq(productEntity.categoryEntity.id))
      .leftJoin(optionGroupEntity).on(optionGroupEntity.id.eq(productEntity.optionGroup.id))
      .where(eqCategory(categoryId))
      .fetch()

    return results.map { tuple ->
      val category = tuple.get(categoryEntity)?.let {
        objectMapper.convertValue(it, Category::class.java)
      }!!

      val optionGroup = tuple.get(optionGroupEntity)?.let {
        objectMapper.convertValue(it, OptionGroup::class.java)
      } ?: null

      ProductRes(
        id = tuple.get(productEntity.id)!!.toLong(),
        name = tuple.get(productEntity.name)!!,
        price = tuple.get(productEntity.price)!!,
        color = tuple.get(productEntity.color)!!,
        category = category,
        optionGroup = optionGroup,
        isTaxIncluded = tuple.get(productEntity.isTaxIncluded)!!,
        status = tuple.get(productEntity.status)!!
      )
    }
  }
  private fun eqCategory(catalogId: Long?) : BooleanExpression? =
    catalogId?.let { productEntity.categoryEntity.id.eq(catalogId) }
}