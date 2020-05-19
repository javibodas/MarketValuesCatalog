import React, { useContext } from 'react';
import { Link } from 'wouter'
import UserContext from '../../../context/userContext';
import logoutUser from '../../../services/users/logoutUser';

import './index.css'

export default function UserProfileCard(props){

    const { user, setUser } = useContext(UserContext);

    const handleLogout = function(event){
      event.preventDefault();

      logoutUser()
      .then((result) => { 
        setUser({'authenticated' : false});
        console.log(result) 
      })
      .catch((error) => { console.log(error) });
      
      document.getElementsByClassName('dropdown-menu')[0].classList.toggle('show');
    }

    return (
      <React.Fragment>
        <h5 className="username">{user.userData.name}</h5>
        <a className="dropdown-item" href="#">Portfolio</a>
        <Link className="dropdown-item" to='/settings'>Settings</Link>
        <div className="dropdown-divider"></div>
        <a className="dropdown-item" href="#" onClick={handleLogout}>Logout</a>
      </React.Fragment>
    );
}