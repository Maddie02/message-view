import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Navbar from './components/Navbar';
import Login from "./components/login.component";
import SignUp from "./components/signup.component";
import User from "./components/user.component";
import Messages from './components/Messages';
import MessageView from './components/MessageView';

function App() {
  return ( 
    <Router>
      <div className="App">
        <Navbar />
        <br />
        <Switch>
          <Route path='/' exact component={Login} />
          <Route path="/log-in" exact component={Login} />
          <Route path="/sign-up" exact component={SignUp} />
          <Route path='/users' component={User} />
          <Route path="/messages" exact component={Messages} />
          <Route path="/message/:id" exact component={MessageView} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;