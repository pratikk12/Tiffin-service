import ProductData from "../assets/products.json";
import "../styles/style.css";


const Mess = () => (
  <div className="product-container">
    {ProductData.map((product) => (
      <div className="product-card" key={product.id}>
        <img src={`/${product.image}`} alt={product.title} className="product-image" />
        <p className="product-title">{product.title}</p>
      </div>
    ))}
  </div>
);

export default Mess;
