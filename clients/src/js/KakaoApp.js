//npm install react-kakao-login
//JS key : 065d7cc570734a5e78235a382cc14183
import React from "react";
import KakaoLogin from "react-kakao-login";
import logo from "../img/kakao_login_medium_narrow.png";

const KakaoApp = () => {

    const kakaoLoginSuccess = (res) => {
        console.log(res);
    }
    const kakaoLoginFailure = (err) => {
        console.log(err);
    }

    return(
        <div>
            <KakaoLogin 
                token="065d7cc570734a5e78235a382cc14183"
                onSuccess={kakaoLoginSuccess}
                onFailure={kakaoLoginFailure}
                //getProfile={true}
                render = {(props) => (
                    <button
                        alt="kakaologin"
                        onClick={props.onClick}
                        style={{border:"none", background:"none"}}
                    ><img src={logo} alt="카카오로그인"/></button>
                )}
            />
        </div>
    )
}

export default KakaoApp;