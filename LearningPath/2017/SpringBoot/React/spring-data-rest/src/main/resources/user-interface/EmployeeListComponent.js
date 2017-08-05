const React = require( 'react' );

const EmployeeComponent = require( './EmployeeComponent' );

export default class EmployeeListComponent extends React.Component {

	render() {
		var employees = this.props.employees.map( employee =>
			<EmployeeComponent key = {employee._links.self.href} employee = {employee} />
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
