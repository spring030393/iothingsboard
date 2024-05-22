package com.iot.iothingsboard.server.common.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iot.iothingsboard.server.common.data.id.CustomerId;
import com.iot.iothingsboard.server.common.data.id.EntityId;
import com.iot.iothingsboard.server.common.data.id.TenantId;
import com.iot.iothingsboard.server.common.data.id.UserId;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class User extends BaseDataWithAdditionalInfo<UserId> implements HasCustomerId, HasTenantId,HasName , NotificationRecipient{
    private TenantId tenantId;
    private CustomerId customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public User(){
        super();
    }
    public User(UserId id){
        super(id);
    }
    public User(User user){
        super(user);
        this.tenantId = user.getTenantId();
        this.customerId=user.getCustomerId();
        this.firstName = user.getFirstName();
        this.lastName =user.getLastName();
        this.phone= user.getPhone();
        this.email=user.getEmail();
    }
    @Schema(description = "JSON object with the User Id. "+
    "Specify this field to udpate the device. "+
    "Referencing non-existing User Id will cause error. "+
    "Omit this field to create new customer.")
    public UserId getId(){
        return super.getId();
    }

    @Schema(description = "JSON object with Tenant Id.", accessMode = Schema.AccessMode.READ_ONLY)
    public TenantId getTenantId() {
        return tenantId;
    }

    public void setTenantId(TenantId tenantId) {
        this.tenantId = tenantId;
    }

    @Schema(description = "JSON object with Customer Id.", accessMode = Schema.AccessMode.READ_ONLY)
    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    @Schema(description = "First name of the user" , example = "John")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Schema(description = "Last name of the user", example="Doe")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Schema(description = "Phone number of the user", example = "38012345123")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,description="Email of the user",example = "user@example.com")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getName() {
        String title = "";
        if(!StringUtils.isBlank(firstName)){
            title +=firstName;
        }
        if(!StringUtils.isBlank(lastName)){
            if(!title.isBlank()){
                title+=" ";
            }
            title += lastName;
        }
        if(title.isBlank()){
            title = email;
        }
        return title;
    }

    @Override
    @JsonIgnore
    public String getTitle() {
        return User.getTitle(email,firstName, lastName);
    }

    @JsonIgnore
    public boolean isSystemAdmin(){
        return tenantId==null || EntityId.NULL_UUID.equals(tenantId.getId());
    }

    @JsonIgnore
    public boolean isTenantAdmin(){
        return !isSystemAdmin() && (customerId == null || EntityId.NULL_UUID.equals(customerId.getId()));
    }

    @JsonIgnore
    public boolean isCustomerUser(){
        return !isSystemAdmin() && !isTenantAdmin();
    }

    public static String getTitle(String email,String firstName,String lastName){
        String title = "";
        if(!StringUtils.isBlank(firstName)){
            title+= firstName;
        }
        if(!StringUtils.isBlank(lastName)){
            if(!title.isBlank()){
                title +=" ";
            }
            title += lastName;
        }
        if(title.isEmpty()){
            title = email;
        }
        return title;
    }
}
