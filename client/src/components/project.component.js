import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import ProjectService from '../services/ProjectService';

export default class ProjectComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            projects:[]
        }
    }

    componentDidMount(){
        ProjectService.getProjects().then((response) => {
            this.setState({ projects: response.data})
        });

        /*ProjectService.getProject("Alfabet").then((response) => {
            this.setState({ projects: response.data})
        });*/
    }

    render (){
        return (
            <div>
                <br />
                <h1 className = "text-center"> Projects List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Project Name</td>
                            <td> Project Description</td>
                            <td> Project version</td>
                            <td> Project creator</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.projects.map(
                                project =>
                                <tr key = {project.projectName}>
                                	<td> <Link className="nav-link" to={`/projects/${project.projectName}`}>{project.projectName}</Link></td>
                                    <td> {project.description}</td>
                                    <td> {project.version}</td>
                                    <td> {project.createdBy}</td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>

        )
    }
}
