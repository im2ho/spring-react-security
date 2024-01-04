import '../css/App.css';
import GoogleApp from './GoogleApp';
import NaverApp from './NaverApp';
import KakaoApp from './KakaoApp';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div style={{textAlign:"center", marginTop:"100px"}}>
      {/*<Link to="/userlist">Users</Link>
      <Link to="/itemlist" style={{marginLeft:"10px"}}>Items</Link>*/}
      <h1>React from SpringBoot</h1> 
      <div className="card py-5" style={{marginTop: "30PX", width:"500px", margin:"auto"}}>
        <h2>Log In</h2>
        <div className="mt-5">
          <GoogleApp />
        </div>
        <div style={{marginTop:"10px"}}>
          <NaverApp  />
        </div>
        <div style={{marginTop:"10px"}}>
          <KakaoApp  />
        </div>
      </div>
    </div>
  );
}

export default App;