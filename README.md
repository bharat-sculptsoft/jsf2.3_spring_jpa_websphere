# JSF-2.3 with spring data jpa with web sphere
JSF 2.3  + spring data jpa + hibernate + maven + Websphere

## Deployment Steps

- Install WebSphere on Windows
  - Go through this video - [Websphere installation](https://www.youtube.com/watch?v=peROboAYXyY)

- Pull the latest code of this repository
  ```bash
  git remote add origin https://github.com/bharat-sculptsoft/jsf2.3_spring_jpa_websphere.git
  git pull origin main
  ```
- Generate maven build
  - Note
    ```bash
    Eclipse should be run as an administrator.
    JDK is required to generate a maven build. 
    ```

  - Update the maven dependency
    ![App Screenshot](https://imgtr.ee/images/2023/08/07/36b9a0ac11c007f13559a895e5267be0.png)
  - Generate maven build
    ![App Screenshot](https://imgtr.ee/images/2023/08/07/e5d83de07723b8db5214a25c13d480a2.png)

- Upload build on Websphere
  - Go through this video - [Upload build into websphere](https://drive.google.com/file/d/1Dzqi__e7Onjyvg3zLt6PORbtImNXmuSh/view?usp=drive_link)
