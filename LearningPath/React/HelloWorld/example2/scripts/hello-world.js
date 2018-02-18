'use strict';

var HelloWorld = React.createClass( {

    render: function() {
        return React.createElement( 'h1', null, 'Hello, World!' );
    },

} );

var mainElement = document.querySelector( 'main' );

ReactDOM.render( React.createElement( HelloWorld ), mainElement );
