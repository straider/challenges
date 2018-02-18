'use strict';

class HelloWorld extends React.Component {

    render() {
        return React.createElement( 'h1', null, 'Hello, World!' );
    }

}

var mainElement = document.querySelector( 'main' );

ReactDOM.render( React.createElement( HelloWorld ), mainElement );
