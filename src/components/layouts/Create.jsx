import React, { useState } from "react";
import axios from "axios";

const Create = () => {
  const [productData, setProductData] = useState({
    productName: "",
    price: "",
    description: "",
    category: "",
  });
  const onChange = (e) => {
    setProductData({ ...productData, [e.target.name]: e.target.value });

    //when state of controller is changing then we are holding that changed value in state
  };
  const onSubmit = (e) => {
    const newProduct = {
      productName: productName,
      price: price,
      description: description,
      category: category,
    };
    e.preventDefault();
    console.log("hello from submit");
    console.log(JSON.stringify(newProduct));
    axios
      .post("http://localhost:9008/api/v1/product", newProduct)
      .then((response) => {
        console.log(response.data);
        localStorage.setItem("data", JSON.stringify(response.data));
      })
      .catch((err) => console.log(JSON.stringify(err)));
  };

  const { productName, price, description, category } = productData;
  return (
    <div>
      <form onSubmit={onSubmit}>
        <table>
          <tr>
            <td>ProductName</td>
            <td>
              <input
                type="text"
                name="productName"
                value={productName}
                onChange={onChange}
              ></input>
            </td>
          </tr>
          <tr>
            <td>Price</td>
            <td>
              <input
                type="text"
                name="price"
                value={price}
                onChange={onChange}
              ></input>
            </td>
          </tr>
          <tr>
            <td>Description</td>
            <td>
              <input
                type="text"
                name="description"
                value={description}
                onChange={onChange}
              ></input>
            </td>
          </tr>
          <tr>
            <td>Category</td>
            <td>
              <input
                type="text"
                name="category"
                value={category}
                onChange={onChange}
              ></input>
            </td>
          </tr>
        </table>
        <input type="submit" value="Submit"></input>
      </form>
    </div>
  );
};

export default Create;
