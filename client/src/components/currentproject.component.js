import React, { Component } from 'react';
import ProjectService from '../services/ProjectService';

export default class CurrentProjectComponent extends Component {
	
    constructor(props, props1){
        super(props)
        this.state = {
            projects:[]
        }
        this.props1 = props;
    }
	
    componentDidMount(){
        ProjectService.getProject(`${this.props.match.params.type}`).then((response) => {
			this.setState({ projects: response.data})
		});
	}

    render (){
        return (
            <div>
                <br />
                <h1 className = "text-center"> Projects List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                        	<td>Project Consistent Id</td>
                        	<td>Project Consistent Product Id</td>
                        	<td>Project Id</td>
                            <td>Project Name</td>
                            <td>Project Locales</td>
                            <td>Project Validator</td>
                            <td> Project Description</td>
                            <td>Project Primary Locale</td>
                            <td> Project version</td>
                            <td> Project creator</td>
                            <td>Project Created Date</td>
                            <td>Project Modifier</td>
                            <td>Project Modified Date</td>
                            
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.projects.map(
                                project => 
                                <tr key = {project.consistentProjectID}>
                                	<td> {project.consistentProjectID}</td>
                                	<td> {project.consistentProductID}</td>
                                	<td> {project.projectID}</td>
                                	<td> {project.projectName}</td>
                                	<td> {project.locales}</td>
                                	<td> {project.regexValidator}</td>
                                	<td> {project.description}</td>
                                	<td> {project.primaryLocale}</td>
                                	<td> {project.version}</td> 
                                    <td> {project.createdBy}</td>
                                	<td> {project.createdDate}</td>
                                	<td> {project.lastModifiedBy}</td>
                                    <td> {project.lastModifiedDate}</td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>

        )
    }
}