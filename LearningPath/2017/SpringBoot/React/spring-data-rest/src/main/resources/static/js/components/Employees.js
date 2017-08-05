import React from 'react';

import Employee from './Employee';

export default class Employees extends React.Component {

	render() {
		var employees = this.props.employees.map( employee =>
			<Employee key = {employee._links.self.href} employee = {employee} />
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Description</th>
					</tr>
					{employees}
				</tbody>
			</table>
		)
	}

}
