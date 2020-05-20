import React, { useContext } from 'react'
import { Link } from 'wouter'
import UserContext from '../../context/userContext';
import UserProfileCard from './UserProfileCard';
import UserLoginCard from './UserLoginCard';
import './index.css';

export default function Header(props){

    const { user, setUser } = useContext(UserContext);

    return(<nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                    <Link className="navbar-brand" to="/">MarketValuesApp</Link>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse">
                        {(  user.authenticated && user.userData.roles.find((element) => element.role == 'ADMINISTRADOR') != undefined) ?
                            <ul className="navbar-nav">
                                <li className="nav-item"><Link className="nav-link" to="/users">Users</Link></li>
                            </ul> 
                        : null}
                        {(  user.authenticated ) ?
                            <ul className="navbar-nav">
                                <li className="nav-item"><Link className="nav-link" to="/users">Portfolio</Link></li> 
                            </ul>
                        : null}
                    </div>
                    <div className="nav-item dropdown user-login">
                        {(!user.authenticated ) ? <img className="nav-link dropdown-toggle profile-img" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" src="images/profile.png" /> :
                                                  <img className="nav-link dropdown-toggle profile-img active-img-profile" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" src="images/profile.png" /> }
                        <div className="dropdown-menu">
                            {(!user.authenticated ) ? <UserLoginCard /> : null }
                            {(user.authenticated ) ? <UserProfileCard /> : null }
                        </div>
                    </div>
                </nav>);
}