import React, { Component } from 'react';
import './bootstrap/css/bootstrap.min.css';
import './nP_Login.css';

class LoginNavPanel extends Component {
  constructor(props){
    super(props);
  }

  render(){
    return(
      <div className="row one">
        <div className="col-md-10 logo">
          <span>TWISTER</span>
        </div>
        <div className="col-md-1 signUp">
          <input onClick = { this.props.signUp }type="button" value="SIGN UP" />
        </div>
        <div className="col-md-1 signIn">
          <input onClick = { this.props.signIn } type="button" value="SIGN IN" />
        </div>
      </div>
    );
  }
}

export default LoginNavPanel;
