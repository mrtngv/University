import React from 'react';
import Navbar from './navbar/Navbar';
import { HashRouter as Router, Switch, Route } from 'react-router-dom';
import Task from './task/Task';
import TaskId from './task/TaskId';
import Dashboard from './task/Dashboard';
import AddTask from './task/AddTask';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {   
    };
  }


  render() {
    return (
        <div>
        <Router>
          <Route path="/" component={Navbar} />
          <Switch>
            <Route path="/tasks" exact component={Task} />
            <Route path="/search" component={TaskId} />
            <Route path="/dashboard" exact component={Dashboard} />
            <Route path="/tasks/add" exact component={AddTask} />
          </Switch>
        </Router>
      </div>
    )
  }
}

export default App;