import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import User from './js/Users';
import Products from './js/Products';
import AddProduct from "./js/AddProduct";

export default function App() {

  return(
    <Router>
      <div style={{textAlign:"center"}}>
        <Link to="/user">UserList</Link>
        <Link to="/item">Product List</Link>
      </div>
      <Routes>
        <Route path="/user" element={<User />} />
        <Route path="/item" element={<Products />} />
        <Route path="/add" element={<AddProduct />} />
      </Routes>
    </Router>
  )
}