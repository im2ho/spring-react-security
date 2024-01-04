import React from 'react';
//npm install react-naver-login
import NaverLogin from "react-naver-login";
import logo from "../img/btnG_완성형.png";

const NaverApp = () => {

    const clientId = 'K4MWh9YEeN4NAcSjXkvV';

    const NaverLoginSuccess = (res) => {
        console.log(res);
    };
    const NaverLoginFailure = (err) => {
        console.log(err);
    }

    //render prop : 사용자가 버튼을 클릭하는 것을 나타내는 추가 구문
    return (
        <div>
            <NaverLogin 
                clientId={clientId}
                callbackUrl="http://localhost:3000/naverLogin"
                onSuccess={NaverLoginSuccess}
                onFailure={NaverLoginFailure}
                render={(props) => (
                    <button 
                        onClick={props.onClick}
                        style={{border:"none", background:"none"}}
                    ><img src={logo} alt="네이버로그인" style={{width:"180px"}}/></button>
                )}
            />
        </div>
    )
}

export default NaverApp;