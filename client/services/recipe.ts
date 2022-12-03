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

  try {
    const res = await axiosInstance(config);
    return res?.data;
  } catch (err) {
    return {};
  }
};

export const getAll = async () => {
  const config = {
    method: "get",
    url: "/recipe/getAll",
    headers: {
      "Content-Type": "application/json",
    },
  };

  try {
    const res = await axiosInstance(config);
    return res?.data;
  } catch (err) {
    return [];
  }
};

export const getFiltered = async (filterParams: {
  ingredients: string[];
  appliances: string[];
  difficultyRating: number | null;
  qualityRating: number | null;
  cusine: string;
  flavor: string;
}) => {
  console.log(filterParams);
  const config = {
    method: "post",
    url: "/recipe/getFiltered",
    headers: {
      "Content-Type": "application/json",
    },
    data: filterParams,
  };

  try {
    const res = await axiosInstance(config);
    return res?.data;
  } catch (err) {
    return [];
  }
};
