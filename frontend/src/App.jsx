import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './component/Login';
import Register from './component/Register';
import Home from './component/Home';
import LockerMaster from './component/LockerMaster';
import DailyVisit from './component/DailyVisit';
import CustomerRegister from './component/CustomerRegister';
import LockerIssue from './component/LockerIssue';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/home" element={<Home/>} />
        <Route path='/lockermaster' element={<LockerMaster/>} />
        <Route path='/dailyvisit' element={<DailyVisit/>} />
        <Route path='/customerRegister' element={<CustomerRegister/>} />
        <Route path='/lockerissue' element={<LockerIssue/>} />
      </Routes>
    </Router>
  );
};

export default App;
