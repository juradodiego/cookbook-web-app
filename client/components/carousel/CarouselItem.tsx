export default function CarouselItem({ children }: any) {
  return (
    <div className="inline-flex p-5 h-80 w-full bg-white rounded-md border border-gray-200">
      {children}
    </div>
  );
}
