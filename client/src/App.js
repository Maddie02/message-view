import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Navbar from './components/Navbar';
import Login from "./components/login.component";
import SignUp from "./components/signup.component";
import Messages from './components/Messages';

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
          <Route path="/messages" exact component={Messages} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
