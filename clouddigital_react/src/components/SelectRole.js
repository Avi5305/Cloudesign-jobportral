import React   from 'react'
import jobseeker from '../images/jobSeekers.jpg'
import recruiter from '../images/employer.jpg'
// import from "react";


export default function SelectRole() {
  
    // const [role,setrole] = useState("");

    function navigateToRecruit() {
        window.location.href = 'RecruiterRegister';
      }


      function navigateToSeek() {
        window.location.href = 'JobSeekerRegister';
      }

  
    return (
    <div>
        <div className='row align-items-center'>
            <div className='col'>
                <img src={jobseeker} onClick={navigateToSeek}></img>
            </div>
            <div className='col'>
                <img src={recruiter} onClick={navigateToRecruit}></img>
            </div>
        </div>
    </div>
  )
}
