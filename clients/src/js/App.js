import '../css/App.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import User from './Users';
import Product from './Products';

function App() {
  return (
    <Router>
      <Link to="/userlist">Users</Link>
      <Link to="/itemlist">Items</Link>
      <h1>React from SpringBoot</h1> 
      <Routes>
        <Route path="/userlist" element={<User />}/>
        <Route path="/itemlist" element={<Product />}/>
      </Routes>
    </Router>
  );
}

export default App;