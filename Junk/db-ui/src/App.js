import React from 'react';
import Navbar from './navbar/Navbar';
import { HashRouter as Router, Switch, Route } from 'react-router-dom';
import AllUniversities from './university/AllUniversities';
import AllStudents from './students/AllStudents';
import AllPrograms from './programs/AllPrograms';

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
            <Route path="/universities" exact component={AllUniversities} />
            <Route path="/students" exact component={AllStudents} />
            <Route path="/programs" exact component={AllPrograms} />
          </Switch>
        </Router>
      </div>
    )
  }
}

export default App;