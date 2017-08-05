const React  = require( 'react'    );
const client = require( './client' );

const EmployeeListComponent = require( './EmployeeListComponent' );

export default class ApplicationComponent extends React.Component {

	constructor( properties ) {
		super( properties );
		this.state = { employees: [] };
	}

	componentDidMount() {
		client( { method: 'GET', path: '/api/employees' } ).done( response => {
			this.setState( { employees: response.entity._embedded.employees } );
		} );
	}

	render() {
		return (
			<EmployeeListComponent employees = {this.state.employees} />
		)
	}

}
