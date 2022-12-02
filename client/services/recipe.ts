import axiosInstance from "./axiosInstance";

export const getById = async (recipeId: number) => {
  const config = {
    method: "get",
    url: "/recipe/get",
    headers: {
      "Content-Type": "application/json",
    },
    params: {
      id: recipeId,
    },
  };

  const res = await axiosInstance(config);
  return res?.data;
};

export const getAll = async () => {
  const config = {
    method: "get",
    url: "/recipe/getAll",
    headers: {
      "Content-Type": "application/json",
    },
  };

  const res = await axiosInstance(config);
  return res?.data;
};
