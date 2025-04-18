import { useEffect, useState } from "react";
import "../shared/styles.css";
import DependencyMappingsPage from "./dependency-mappings-page";
import LicenseMappingsPage from "./license-mappings-page";
import LicensesPage from "./licenses-page";
import ProjectLicensesPage from "./project-licenses-page";

const Configuration = () => {
  const [currentRoute, setCurrentRoute] = useState("licenses");

  useEffect(() => {
    const result = window.location.search.match(/category=([^&=]*)/);
    if (result && result.length > 1) {
      setCurrentRoute(result[1]);
    }
  }, []);

  const activateCategory = (event, route) => {
    event.preventDefault();
    setCurrentRoute(route);
    window.history.pushState({}, document.title, `?category=${route}`);
  };

  return (
    <div className="sqlc-page">
      <ul className="sw-flex sw-items-end sw-gap-8 sw-mt-4">
        <li>
          <a
            href="?category=licenses"
            className="sw-flex sw-items-center"
            style={currentRoute === "licenses" ? { borderBottomColor: "rgb(123, 135, 217)" } : {}}
            onClick={(e) => activateCategory(e, "licenses")}
          >
            Licenses
          </a>
        </li>
        <li>
          <a
            href="?category=license-mappings"
            className={currentRoute === "license-mappings" ? "selected" : ""}
            onClick={(e) => activateCategory(e, "license-mappings")}
          >
            License Mappings
          </a>
        </li>
        <li>
          <a
            href="?category=dependency-mappings"
            className={currentRoute === "dependency-mappings" ? "selected" : ""}
            onClick={(e) => activateCategory(e, "dependency-mappings")}
          >
            Dependency Mappings
          </a>
        </li>
        <li>
          <a
            href="?category=project-licenses"
            className={currentRoute === "project-licenses" ? "selected" : ""}
            onClick={(e) => activateCategory(e, "project-licenses")}
          >
            Project Licenses
          </a>
        </li>
      </ul>
      <br />
      {currentRoute === "licenses" && <LicensesPage />}
      {currentRoute === "dependency-mappings" && <DependencyMappingsPage />}
      {currentRoute === "license-mappings" && <LicenseMappingsPage />}
      {currentRoute === "project-licenses" && <ProjectLicensesPage />}
    </div>
  );
};

export default Configuration;
