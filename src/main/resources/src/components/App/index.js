import ReactDOM from 'react-dom'
import React from 'react'
import { Router, Route } from 'wouter'
/** HEADER */
import Header from '../Header'
/** SEARCH VALUES */
import Search from '../SearchValues'
/**  USERS **/
import SettingsUser from '../Users/SettingsUser';
import CreateUser from '../Users/CreateUser';
import Users from '../Users';
/** FOOTER */
import Footer from '../Footer';
/** USER CONTEXT */
import { UserContextProvider } from '../../context/userContext'; 



function App() {
  return (<React.Fragment>
              <UserContextProvider>
                <Header />
                <Router>
                    <Route path="/" component={Search} />
                    <Route path="/createUser" component={CreateUser} />
                    <Route path="/users" component={Users} />
                    <Route path="/settings" component={SettingsUser} />
                </Router>
              </UserContextProvider>
              <Footer />
            </React.Fragment>);
}

export default App;

ReactDOM.render(<App />, document.getElementById('root'));

