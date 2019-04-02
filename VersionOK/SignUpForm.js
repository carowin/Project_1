import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/SignUpB.css';
import MainPage from './MainPage.js';


class SignUpForm extends Component {
  constructor(props){
    super(props);
  }
  render(){

    return (
      <div className="row">
     <div className="col-md-7">
       <div className="form">
         <h1>SIGN UP</h1>

         <form action="">
           <div className="input">
             <input type="text" name="username" id="usernam" placeholder="USERNAME" /><br />
             <input type="text" name="nam" id="NAME" placeholder="NAME"/><br />
             <input type="text" name="login" id="login" placeholder="LOGIN"/><br />
             <input type="text" name="mail" id="email" placeholder="MAIL"/><br />
             <input type="password" name="password" id="password" placeholder="PASSWORD"/><br />
             <input type="password" name="retype" id="retype" placeholder="TYPE AGAIN"/><br />
           </div>

           <div className="submit"><br />
             <input onClick = {this.props.setLogout} type="submit" value="Cancel" />
             <input onClick = {this.props.setSignIn} type="submit" value="Enter" />
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

export default SignUpForm;
