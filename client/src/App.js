import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { CookiesProvider } from 'react-cookie';

import Home from './components/Home';
import Navbar from './components/Navbar';
import Login from "./components/login.component";
import SignUp from "./components/signup.component";
import User from "./components/user.component";
import Messages from './components/Messages';
import MessageView from './components/MessageView';

function App() {
  return (
    <CookiesProvider>
      <Router>
        <div className="App">
          <Navbar />
          <br />
          <Switch>
            <Route path='/' exact component={Home} />
            <Route path="/log-in" exact component={Login} />
            <Route path="/sign-up" exact component={SignUp} />
            <Route path='/users' component={User} />
            <Route path="/messages" exact component={Messages} />
            <Route path="/message/:id" exact component={MessageView} />
          </Switch>
        </div>
      </Router>
    </CookiesProvider>
  );
}

export default App;
