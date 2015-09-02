/****
Copyright (c) 2015 The Jackson Laboratory

This is free software: you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by  
the Free Software Foundation, either version 3 of the License, or  
(at your option) any later version.
 
This software is distributed in the hope that it will be useful,  
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with this software.  If not, see <http://www.gnu.org/licenses/>.
****/

package jcms.web.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import jcms.integrationtier.dao.CVAdministrationDAO;
import jcms.integrationtier.dto.AdminStrainDTO;
import jcms.web.base.WTBaseConverter;

/**
 *
 * @author cnh
 */
public class AdminStrainDTOConverter extends WTBaseConverter implements Converter {

    /**
     * Purpose: Convert the string value, primary key, selected by the User
     *      from a list of SelectItems and return the corresponding object the
     *      key maps to.
     * @param context Java Server Faces context
     * @param component JSF UIComponent
     * @param value key value selected from JSF SelectItem component
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, 
    String value) {
        AdminStrainDTO entity = null;
        try {
            if (value != null && (!value.equals(""))) {
                entity = findDTO(value);
            }
        } catch (NullPointerException npe) {
            this.getLogger().logWarn(this.formatLogMessage("NullPointerException ", "getAsObject"));
            throw new ConverterException("Trying to convert a null Strain.  "
                    + "Please report this to the system administrator.  ");
        }        
        catch (Exception npe) {
            this.getLogger().logWarn(this.formatLogMessage("Exception ", "getAsObject"));
            throw new ConverterException("Trying to convert a null Strain.  "
                    + "Please report this to the system administrator.  ");
        }

        return entity;
    }

    /**
     * Purpose: Convert the object type, entity or dto, selected by the User
     *      from a list of SelectItems and return the corresponding primary key
     *      the entity maps to.
     * @param context Java Server Faces context
     * @param component JSF UIComponent
     * @param value entity or dto selected from JSF SelectItem component
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String key = "";

        if (value != null && (!value.equals(""))) {
            key = (((AdminStrainDTO) value).getStrainKey()).toString();
        }

        return key;
    }

    /**
     * Purpose:  Find the controlled vocabulary data type object for the
     *      given data type key.
     * Overview:  Converts the unique String representation of AdminStrainDTO
     *      to the actual object.
     * @param key primary key
     * @return AdminStrainDTO object
     */
    private AdminStrainDTO findDTO(String key) throws Exception {
        CVAdministrationDAO dao = new CVAdministrationDAO();
        AdminStrainDTO dataTypeObject = null;

        try {
            for (AdminStrainDTO e : dao.getStrainVocabulary()) {
                if (key.equalsIgnoreCase(e.getStrainKey().toString())) {
                    dataTypeObject = e;
                    break;
                }
            }
        } catch (NullPointerException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = this.getMessage(context, "Invalid Key");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(FacesMessage.FACES_MESSAGES, message);
            this.getLogger().logWarn(this.formatLogMessage("NullPointerException ", "getAsObject"));
        }
        return dataTypeObject;
    }
    
}
