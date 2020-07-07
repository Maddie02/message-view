import React, { Component } from "react";

export default class SignUp extends Component {
    render() {
        return (
            <div className="auth-wrapper">
                <div className="auth-inner">
                <form action="http://localhost:8080/register" method="POST">
                    <h3>Sign Up</h3>
                    <div className="form-group">
                        <label>Username</label>
                        <input type="text" name="username" className="form-control" placeholder="Enter username" />
                    </div>

                    <div className="form-group">
                        <label>Password</label>
                        <input type="password" name="password" className="form-control" placeholder="Enter password" />
                    </div>

                        <button type="submit" className="btn btn-primary btn-block">Sign Up</button>
                        <p className="forgot-password text-right">
                            Already registered <a href="/">log in?</a>
                        </p>
                </form>
                </div>
            </div>
        );
    }
}
