import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/ConnectionB.css';

class SignInForm extends Component {
  constructor(props){
    super(props);
  }

  render(){
    return(
      <div className="row">
        <div className="col-md-7">
          <h1>TWISTER</h1>

          <div className="form">
            <form action="" method="get">
              <input className="login" type="text" name="login" id="login" placeholder="LOGIN"/><br />
              <input className="pwd" type="password" name="password" id="password" placeholder="PASSWORD"/><br />

              <div className="submit">
                <input onClick={this.props.login}className="enter" type="submit" value="ENTER" /><br/>
              </div>

              <div className="link">
                <a  className="resetPwd" href=" ">Reset password</a>
                <a className="signUp" href="SignUp.html">Sign Up</a>
              </div>

            </form>
          </div>
        </div>

        <div className="col-md-5">
          <img className="img" src={marble}/>
        </div>
    </div>
    );
  }
}

export default SignInForm;
