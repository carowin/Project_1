import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/ConnectionB.css';
import NavigationPanel from './NavigationPanel.js';
import SignUpPage from './SignUpPage.js';
//import ResetPwd from './ResetPassword.js';

class Login extends Component {

	constructor(props){
		super(props);
		this.state = { login : false, resetPwd : false, signUp : false };
		this.submitLogin = this.submitLogin.bind(this);
		this.resetPwd = this.resetPwd.bind(this);
		this.signUp = this.signUp.bind(this);
	}

	submitLogin() {
		this.setState({ login : true });
	}

	resetPwd() {
		this.setState({ resetPwd : true });
	}

	signUp(){
		this.setState({ signUp : true });
	}

	render(){
		if(this.state.signUp == true){
			return (<SignUpPage/>);
		}
		if(this.state.login == true){
			return (<NavigationPanel />);
		}else{
			return (
	    	<div className="row">
	        	<div className="col-md-7">
	        		<h1>TWISTER</h1>

	          		<div className="form">
		            	<form action="" method="get">
		              		<input className="login" type="text" name="login" id="login" placeholder="LOGIN"/><br />
		              		<input className="pwd" type="password" name="password" id="password" placeholder="PASSWORD"/><br />

		              		<div className="submit">
		                	<input onClick ={this.submitLogin} className="enter" type="submit" value="ENTER" /><br/>
		              		</div>

		              		<div className="link">
		                		<a onClick ={this.resetPwd} className="resetPwd">Reset password</a>
		                		<a onClick ={this.signUp} className="SignUpPage">Sign Up</a>
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
}

export default Login;
