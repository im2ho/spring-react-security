//App.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
//import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
//Switch -> Routes
import { Link } from 'react-router-dom';

//react-router-dom
function Products() {
  //data 가 아닌 products 로 적을 예정
  const [products, setProducts] = useState([]);

  //get axios api
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/item');
        setProducts(response.data);
      } catch (error) {
        console.log('데이터를 불러오지 못했습니다.', error);
      }
    };
    fetchData();
  }, []);

  const handleDeleteProduct = (id) => {
    axios.delete(`http://localhost:8080/api/detle/${id}`)
    .then(() => {
        setProducts((prevProduct) => 
        prevProduct.filter((product) => product.id !== id));
    })
    .catch((err) => {
        console.error('error ', err);
    })
  }

  return (
      <div style={{textAlign:"center"}}>
        <h1>상품 리스트</h1>
        <ul>
          {products.map((product) => (
            <li key={product.id}>
              {product.name} - {product.price}원
              <button onClick={() => handleDeleteProduct(product.id)}>X</button>
            </li>
          ))}
          <li><Link to="/add">상품 추가하기</Link></li>
        </ul>
      </div>
  );
}
export default Products;