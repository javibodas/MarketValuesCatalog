import ReactDOM from 'react-dom'
import React from 'react'
import { Router, Route } from 'wouter'
import Header from '../Header'
import Search from '../SearchValues'
import CreateUser from '../CreateUser';
import LoginUser from '../LoginUser';
import Footer from '../Footer'



function App() {
  return (<React.Fragment>
            <Header />
            <Router>
                <Route path="/" component={Search} />
                <Route path="/createUser" component={CreateUser} />
                <Route path="/loginUser" component={LoginUser} />
            </Router>
            <Footer />
          </React.Fragment>);
}

export default App;

ReactDOM.render(<App />, document.getElementById('root'));

