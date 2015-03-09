package demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController( '/' )
class SimpleController {

    @RequestMapping( value = '/{id}', method = RequestMethod.GET )
    ResponseEntity<String> handleGet( @PathVariable( 'id' ) String id ) {
        ResponseEntity<String> responseEntity
        if ( id.toLowerCase().contains( 'fail' ) ) {
            responseEntity = new ResponseEntity<String>( 'GET forced to fail', HttpStatus.INTERNAL_SERVER_ERROR )
        }
        else {
            responseEntity = new ResponseEntity<String>( 'GET successful', HttpStatus.OK )
        }
        responseEntity
    }

    @RequestMapping( method = RequestMethod.POST )
    ResponseEntity<String> handlePost( @RequestBody String payload ) {
        ResponseEntity<String> responseEntity
        if ( payload.toLowerCase().contains( 'fail' ) ) {
            responseEntity = new ResponseEntity<String>( 'POST forced to fail', HttpStatus.INTERNAL_SERVER_ERROR )
        }
        else {
            responseEntity = new ResponseEntity<String>( 'POST successful', HttpStatus.CREATED )
        }
        responseEntity
    }
}
