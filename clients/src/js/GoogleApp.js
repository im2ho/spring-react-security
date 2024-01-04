//npm i @react-ouath/google@latest
import {GoogleLogin} from "@react-oauth/google";
import {GoogleOAuthProvider} from "@react-oauth/google";

const GoogleLoginButton = () => {
    
    const clientId = '612474417344-nafm9v32lqfi7spdjm4gk4cm3rug4or6.apps.googleusercontent.com';
    
    const GoogleLoginSuccess = (res) => {
        console.log(res);
    }
    const GoogleLoginFailure = (err) => {
        console.log(err);
    }

    return(
        <div style={{marginLeft:"150px"}}>
            <GoogleOAuthProvider clientId={clientId}>
                <GoogleLogin 
                    onSuccess={GoogleLoginSuccess}
                    onFailure={GoogleLoginFailure}
                />
            </GoogleOAuthProvider>
        </div>
    )
}

export default GoogleLoginButton;