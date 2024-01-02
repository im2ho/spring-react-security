//import logo from './logo.svg';
import './App.css';
import React, {useState, useEffect} from 'react';
import axios from 'axios';

function App() {

  const [data, setData] = useState('');
  const [newUser, setNewUser] = useState('');

  //fetchData라는 이름을 정의해서 try-catch 문을 사용해 비동기 작업 중
  //발생하는 
  useEffect(() => {
    const fetchData = async() => {
      try{
        const res = await axios.get('http://localhost:8080/api/user', {withCredentials:true});
        setData(res.data);
      } catch(err){
        console.log("데이터 없음", err);
      }
    };
    fetchData();
  },[]);
  
  /*
  //useEffect 안에서 
  useEffect(() => {
    axios
    .get('http://localhost:8080/api/', {withCredentials:true})
    //response 변수명 임의 설정 가능
    .then((res) => {
      setData(res.data);
    })
    .catch((err) => {
      console.log("데이터 없음",err);
    });
  }, []);*/

  //데이터 작성한 내용으로 변경하는 함수
  const handleInputChange = (e) => {
    const {name, value} = e.target;
    setNewUser((prevUser) => ({...prevUser, [name] : value}));
  };

  //전송하는 버튼 함수, 데이터 보내줄 post 추가
  const handleAddUser = async() => {
    try{
      const response = await axios.post(
      'http://localhost:8080/api/user', newUser, {withCredentials:true})
      //변경된 데이터 값 저장
      setData((prevUser) => [...prevUser, response.data]);
      //데이터 저장 후 빈값으로 초기화 원한다면 
      setNewUser({username:'', email:''});
    } catch(err) {
      console.log("부적합한 데이터 : ",err);
    }
}

  return (
    <div style={{textAlign:"center"}}>
      <h1>API 호출 확인</h1>
      <ul>
        { data &&
          data.map((user) => (
            <li key={user.id} style={{listStyle:"none"}}>
              {user.username} = {user.email}
            </li>
        ))}  
      </ul><br />

      <h2>New User Info</h2>
      <div>
          <label>user name : </label>
          <input
            type="text"
            name="username"
            value={newUser.username}
            onChange={handleInputChange}
          /><br/>
          <label>e-mail : </label>
          <input
            type="text"
            name="email"
            value={newUser.email}
            onChange={handleInputChange}
          />
      </div>
      <button onClick={handleAddUser}>save</button>
    </div>
  );
}

export default App;