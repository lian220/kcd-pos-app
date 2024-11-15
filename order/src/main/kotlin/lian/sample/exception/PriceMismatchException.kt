package lian.sample.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class PriceMismatchException(message: String) : BusinessException(HttpStatus.NOT_FOUND, "상품의 가격이 다릅니다. (${message})")