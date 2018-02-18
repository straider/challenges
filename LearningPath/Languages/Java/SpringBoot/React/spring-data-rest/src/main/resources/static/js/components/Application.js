import React  from 'react';
import client from '../client';

import Employees from './Employees';

export default class Application extends React.Component {

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
			<Employees employees = {this.state.employees} />
		)
	}

}
