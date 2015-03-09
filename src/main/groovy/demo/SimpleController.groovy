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
        if ( id.toLowerCase().contains( 'fail' ) ) {
            throw new RuntimeException( 'Forced to fail!')
        }

        new ResponseEntity<String>( 'GET successful', HttpStatus.OK )
    }

    @RequestMapping( method = RequestMethod.POST )
    ResponseEntity<String> handlePost( @RequestBody String payload ) {
        if ( payload.toLowerCase().contains( 'fail' ) ) {
            throw new RuntimeException( 'Forced to fail!')
        }
        new ResponseEntity<String>( 'POST successful', HttpStatus.CREATED )
    }
}
