package demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController( '/' )
class SimpleController {

    @RequestMapping( method = RequestMethod.GET )
    ResponseEntity<String> handleGet() {
        new ResponseEntity<String>( 'GET successful', HttpStatus.OK )
    }
}
