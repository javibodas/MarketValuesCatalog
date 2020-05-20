import React, { useContext, useState } from 'react';
import { Link } from 'wouter'
import UserContext from '../../../context/userContext';
import loginUser from '../../../services/users/loginUser';
import getAuthenticatedUser from '../../../services/users/getAuthenticatedUser'
import './index.css';

export default function UserLoginCard(props){

    const { user, setUser } = useContext(UserContext);
    const [errLogin , setErrLogin ] = useState(false)

    function handleLoginUser(event){
      event.preventDefault();
      var user = document.getElementsByName('username')[0].value;
      var pass = document.getElementsByName('password')[0].value;
        
      loginUser({'username': user, 'password' : pass})
      .then((response) => {
        if(response.ok){
  
          // Obtain user authenticated
            getAuthenticatedUser(response.headers.get('Authorization'))
            .then((result) => {
                setUser({ 'authenticated' : true, 'userData': result, 'token' : response.headers.get('Authorization') });
                document.getElementsByClassName('dropdown-menu')[0].classList.toggle('show');
            })
            .catch((error) => console.log(error));

        }else{
            setErrLogin(true);
        }
      })
      .catch((error) => { setErrLogin(true); console.log(error) });
    }

    return (
        <form onSubmit={handleLoginUser} id='login-form'>
          {errLogin ?
            <div className="form-group row">
              <div class="alert alert-danger" role="alert">
                Incorrect credentials
              </div>
            </div> : null
          }
          <div className="form-group row">
            <label for="inputEmail3" className="col-sm-2 col-form-label">Username</label>
            <div className="col-sm-10">
              <input type="text" className="form-control" name="username"/>
            </div>
          </div>
          <div className="form-group row">
            <label for="inputPassword3" className="col-sm-2 col-form-label">Password</label>
            <div className="col-sm-10">
              <input type="password" className="form-control" name="password"/>
            </div>
          </div>
          <div className="form-group row">
            <Link className="col-sm-10" to="/createUser"> Sign Up</Link>
          </div>
          <div className="form-group row">
            <Link className="col-sm-12" to="/"> ¿Forgot your password? </Link>
          </div>
          <div className="form-group row">
            <div className="col-sm-12">
              <button type="submit" className="btn btn-primary">Sign in</button>
            </div>
          </div>
        </form>
    );
}