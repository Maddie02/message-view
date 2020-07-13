import React, { Component } from 'react';
import UserService from '../services/UserService';

export default class UserComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ users: response.data})
        });
    }

    render (){
        return (
            <div>
                <br />
                <h1 className = "text-center"> Users List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> User Name</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user =>
                                <tr key = {user.username}>
                                     <td> {user.username}</td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>

        )
    }
}
