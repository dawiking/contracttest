package contact

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url "/contact"
        headers {
            accept(applicationJson())
        }
    }
    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body([
          "name" : "David Söder"
        ])
        async()
    }
}
