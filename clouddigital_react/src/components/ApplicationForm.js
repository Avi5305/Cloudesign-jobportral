import React from 'react'
import { useState } from 'react'
// import { useLocation } from 'react-router-dom';
// import { Params } from 'react-router-dom';
import { useParams } from 'react-router-dom';


export default function ApplicationForm() {


      const[appid, setAppid]= useState();

  const params = useParams();
  console.log(params.pid);
    const[msg, setMsg]= useState("")
    const [state, setState] = useState({
      experience: "",
      jobseeker: {
        fname: JSON.parse(localStorage.getItem("loggeduser")).fname,
        lname: JSON.parse(localStorage.getItem("loggeduser")).lname,
        contact_no: JSON.parse(localStorage.getItem("loggeduser")).contact_no,
        user: {
          email:""
        }
      },
      resume: null
    });




    console.log(JSON.parse(localStorage.getItem("loggeduser")).job_seeker_id)
    const handleInput=(ev)=>{
      setState((state)=>(
       {
           ...state,
           [ev.target.name]: ev.target.value 
       }
   ));
}

const handleSubmit = (ev) => {
  ev.preventDefault();

  const req = {
    method: 'POST',
    headers: {
      // 'Content-Type': 'multipart/form-data'
      'content-type': 'application/json'
    },
    body: JSON.stringify({
  fname: state.jobseeker.fname,
  lname:state.jobseeker.lname,
  contact_no:state.jobseeker.contact_no,
  email:state.jobseeker.user.email,
  experience:state.experience,
  jobseeker:state.jobseeker,
  position:params.pid
    })
  };

  fetch("http://localhost:8080/addapplication", req)
            .then(resp => resp.json())
            .then(data =>{
                 console.log(data);
              //  setAppid(data.appid);
              //  appid= data.appid;
              //   console.log(appid);
                if(data.appid != 0)
                {
                    let formData = new FormData();
                    formData.append("resume",state.resume)
                    const req1= {
                        method: 'POST',
                        headers: {
                            //'content-type': 'multipart/form-data'
                        },
                        body:  formData
                    } 
                    fetch("http://localhost:8080/addapplicationdocs/"+ data.appid,req1)
                    .then(resp => resp.json())
                    .then(data => {
                        console.log(data)
                        if(data.applid != 0)
                        {
                            setMsg("Application Submitted")
                        }
                    });
                }
                else
                {
                    setMsg("Application not submitted")
                }                
            });           
        }


const handleReset = () => {
  setState({
    experience: '',
    jobseeker: {
      fname: JSON.parse(localStorage.getItem('loggeduser')).fname,
      lname: JSON.parse(localStorage.getItem('loggeduser')).lname,
      contact_no: JSON.parse(localStorage.getItem('loggeduser')).contact_no,
      user: {
        email: JSON.parse(localStorage.getItem('loggeduser')).user.email,
      },
    },
    resume: null,
  });
  setMsg('');
};

const handleFileInput=(ev)=>{
   console.log(ev.target.files[0])
   setState((state)=>(
    {
        ...state,
        [ev.target.name]: ev.target.files[0] 
    }
));
}
    
  return (
    <div>
    {msg && <div>{msg}</div>}
    <form onSubmit={handleSubmit} onReset={handleReset} encType="multipart/form-data" className="container">
      <div className="form-group">
        <div className="form-group">
          <label htmlFor="fname">First Name:</label>
          <input type="text" name="fname" id="fname" className="form-control" value={state.jobseeker.fname} onChange={handleInput} required />
        </div>

        <div className="form-group">
          <label htmlFor="lname">Last Name:</label>
          <input type="text" name="lname" id="lname" className="form-control" value={state.jobseeker.lname} onChange={handleInput} required />
        </div>

        <div className="form-group">
          <label htmlFor="contact_no">Contact Number:</label>
          <input type="tel" name="contact_no" id="contact_no" className="form-control" value={state.jobseeker.contact_no} onChange={handleInput} required />
        </div>
<div class="form-group">
    <label for="email">Email:</label>
    <input type="email" name="email" id="email" class="form-control" onChange={handleInput} required/>
  </div>
  <div className="form-group">
    <div className="form-group">
            <label htmlFor="experience">Experience:</label>
            <input name="experience" id="experience" className="form-control" value={state.experience} onChange={handleInput} required></input>
          </div>
            <label htmlFor="resume">Resume:</label>
            <input type="file" name="resume" id="resume" className="form-control" accept=".pdf,.doc,.docx" onChange={handleFileInput} required />
          </div>

          

          <div className="form-group">
            <button type="submit" className="btn btn-primary">Submit</button>
            <button type="reset" className="btn btn-secondary">Reset</button>
          </div>
        </div>
      </form>
    </div>
  )
}
