import React, { useState } from "react";
import { eventService } from "../../services/eventService";


const AdminEventCard = ({ event, onUpdate, onEdit }) => {
 const [showStatusDropdown, setShowStatusDropdown] = useState(false);


 const handleDelete = async () => {
   if (!window.confirm("Are you sure you want to delete this event?")) return;


   try {
     await eventService.deleteEvent(event.eventId);
     onUpdate();
   } catch (error) {
     console.error("Failed to delete event:", error);
   }
 };


 const handleStatusChange = async (newStatusId) => {
   try {
     await eventService.updateEventStatus(event.eventId, newStatusId);
     setShowStatusDropdown(false);
     onUpdate();
   } catch (error) {
     console.error("Failed to update event status:", error);
   }
 };


 return (
   <div className="admin-event-card">
     <h4>{event.title}</h4>




     <p><strong>Start:</strong> {event.startDate?.replace("T", " ")}</p>
     <p><strong>End:</strong> {event.endDate?.replace("T", " ")}</p>
     <p><strong>Location:</strong> {event.location}</p>




     <div className="admin-event-card-controls">


       {/* Edit Button */}
       <button className="admin-edit-btn" onClick={() => onEdit(event)}>
         Edit
       </button>


       {/* Delete Button */}
       <button className="admin-delete-btn" onClick={handleDelete}>
         Delete
       </button>


       {/* Status Update */}
       <div className="admin-status-wrapper">
         <button
           className="admin-status-btn"
           onClick={() => setShowStatusDropdown(!showStatusDropdown)}
         >
           Update Status
         </button>


         {showStatusDropdown && (
           <select
             className="admin-status-dropdown"
             onChange={(e) => handleStatusChange(Number(e.target.value))}
             defaultValue=""
           >
             <option value="" disabled>
               Select Status
             </option>
             <option value="1">Scheduled</option>
             <option value="2">Cancelled</option>
             <option value="3">Completed</option>


           </select>
         )}
       </div>
     </div>
   </div>
 );
};


export default AdminEventCard;
