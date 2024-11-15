package lian.sample.exception

import org.springframework.http.HttpStatus
class NoSuchProductException(message: String) : BusinessException(HttpStatus.NOT_FOUND, "상품을 찾을 수 업습니다. (${message})")