import "./App.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Home from "./components/layouts/Home";
import Create from "./components/layouts/Create";

function App() {
  return (
    <Router>
      <Route exact path="/" component={Home}></Route>
      <Route exact path="/create" component={Create}></Route>
    </Router>
  );
}

export default App;
