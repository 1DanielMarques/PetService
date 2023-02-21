package br.com.petservice.infra.services;

/*@Service
@RequiredArgsConstructor
public class OwnerService implements FindOwner, UpdateOwner, DeleteOwner {

    private final OwnerRepositoryImpl ownerRepository;
    private final AddressRepositoryImpl addressRepository;
    private final PetRepositoryImpl petRepository;
    private final OwnerAssembler assembler;


    public Owner create(Owner owner) {
        owner.setAddress(addressRepository.save(owner.getAddress()));
        owner.setPet(petRepository.save(owner.getPet()));
        ownerRepository.save(owner);
        return owner;
    }

    public List<OwnerDTO> findAll() {
        List<OwnerDTO> ownerDTOList = getAllOwners().stream()
                .map(owner -> new OwnerDTO(owner.getId(),
                        owner.getName(),
                        owner.getMainPhone(),
                        owner.getEmergencyPhone(),
                        owner.getAddress().getStreet(),
                        owner.getAddress().getDistrict(),
                        owner.getAddress().getHouseNumber(),
                        owner.getPet().getName(),
                        owner.getPet().getBreed(),
                        owner.getPet().getDailyTimesToEat(),
                        owner.getPet().getTimeToEat().stream().map(LocalTime::toString).collect(Collectors.toList()),
                        owner.getPet().getObservation())).collect(Collectors.toList());
        return ownerDTOList;
    }

    public OwnerDTO findById(Long id) {
        try {
            return assembler.toOwnerDTO(ownerRepository.findById(id));
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
    }


    private List<Owner> getAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(object -> OwnerEntity.class.cast(object))
                .map(OwnerEntity::toOwnerFromEntity).
                collect(Collectors.toList());
    }

    public OwnerDTO updateById(Long id, OwnerDTO ownerDTO) {
        try {
            Owner updatedOwner = ownerRepository.findById(id);
            updateOwnerData(updatedOwner, ownerDTO);
            addressRepository.save(updatedOwner.getAddress());
            petRepository.save(updatedOwner.getPet());
            ownerRepository.save(updatedOwner);
            return assembler.toOwnerDTO(updatedOwner);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateOwnerData(Owner updatedOwner, OwnerDTO ownerDTO) {
        updatedOwner.setName(ownerDTO.ownerName());
        updatedOwner.setMainPhone(ownerDTO.mainPhone());
        updatedOwner.setEmergencyPhone(ownerDTO.emergencyPhone());

        updatedOwner.getAddress().setStreet(ownerDTO.street());
        updatedOwner.getAddress().setDistrict(ownerDTO.district());
        updatedOwner.getAddress().setHouseNumber(ownerDTO.houseNumber());

        updatedOwner.getPet().setName(ownerDTO.petName());
        updatedOwner.getPet().setBreed(ownerDTO.breed());
        updatedOwner.getPet().setDailyTimesToEat(ownerDTO.dailyTimesToEat());
        updatedOwner.getPet().setTimeToEat(ownerDTO.timeToEat()
                .stream()
                .map(LocalTime::parse)
                .collect(Collectors.toList()));
        updatedOwner.getPet().setObservation(ownerDTO.observation());
    }


    public void deleteById(Long id) {
        try {
            Long petId = ownerRepository.findById(id).getPet().getId();
            Long addressId = ownerRepository.findById(id).getAddress().getId();
            ownerRepository.delete(id);
            petRepository.delete(petId);
            addressRepository.delete(addressId);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }

    }
}*/
